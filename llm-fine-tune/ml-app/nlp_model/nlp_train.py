import json
import re

import pandas as pd
import joblib
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.svm import LinearSVC
from sklearn.pipeline import Pipeline
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report

input_file = "../generated_data/train.jsonl"
output_file = "../generated_data/train_c.jsonl"

def clean_data(input_file, output_file):
    with open(input_file, 'r') as f_in, open(output_file, 'w') as f_out:
        for line in f_in:
            try:
                data = json.loads(line)
                data['input'] = data['input'].replace('\"', '') #clean /"
                data['input'] = re.sub(r'0{5,}', '', data['input']) #clean repeat character 
                f_out.write(json.dumps(data) + '\n')
            except json.JSONDecodeError:
                continue

    print("Done")

clean_data(input_file, output_file)

print("Loading training dataset")
df = pd.read_json(output_file, lines=True)

pipeline = Pipeline([
    ('tfidf', TfidfVectorizer(
        stop_words="english", 
        max_features=1000,
        ngram_range=(1,1),
        dtype='float32')
    ),
    ("clf", LinearSVC(class_weight='balanced')),
])

#train
print("Training Model...")
X_train, X_test, y_train, y_test = train_test_split(df['input'], df['output'], test_size=0.1, random_state=42)
pipeline.fit(X_train, y_train)

joblib.dump(pipeline, "service_classifier.pkl")
print("Model saved")