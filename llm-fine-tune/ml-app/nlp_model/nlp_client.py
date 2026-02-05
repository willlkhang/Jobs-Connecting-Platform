import joblib

model = joblib.load("service_classifier.pkl")
user_input = "I have leak water on floor"
predict = model.predict([user_input])[0]

print(f"Category: {predict}")