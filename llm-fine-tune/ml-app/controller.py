from flask import Flask
from flask_restful import Resource, Api, reqparse, fields, marshal_with, abort

app = Flask(__name__)
api = Api(app)

clientFields = {
    'message':fields.String
}

class ClientInput(Resource):
    @marshal_with(clientFields)
    def getResponse(self):
        