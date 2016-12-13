import requests,json

# The variables
key ="api_key"
secret ="api_secret"
url ="https://corenlp.ai"
text ="the fox jumped over the lazy dog"

# Issue the request
response = requests.post(url, data="the fox jumped over the lazy dog")
annotated = json.loads(response.text)

# Print, e.g., the relation triples in the sentence
triples = map ( lambda x: "(%s; %s; %s)" % (x['subject'], x['relation'], x['object']), annotated['sentences'][0]['openie'] )

for triple in triples:
   print(triple)
