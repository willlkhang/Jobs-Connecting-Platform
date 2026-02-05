from flask import Flask
from flask_restful import Resource, Api, reqparse, fields, marshal_with, abort

import joblib

app = Flask(__name__)
api = Api(app)

MODEL = joblib.load("../nlp_model/service_classifier.pkl")
parser = reqparse.RequestParser()
parser.add_argument('message', type=str, required=True, help="Message cannot be blank")

clientFields = {
    'prediction':fields.String
}

class ClientInput(Resource):
    @marshal_with(clientFields)
    def post(self):
        args = parser.parse_args()
        message = args['message']
        prediction = MODEL.predict([message])[0]

        return {'prediction': str(prediction)}
    
api.add_resource(ClientInput, '/api/predict')

@app.route('/')
def home():
    return '<h1>test</h1>'

if __name__ == '__main__':
    app.run(debug=True)