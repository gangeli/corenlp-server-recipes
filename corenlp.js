var request = require('request');

// The parameters of the POST request
var params = {
   url: 'https://corenlp.ai',
   auth: {
      user: 'api_key',
      password: 'api_secret'
   },
   form: 'The brown fox jumped over the lazy dog'
}

// Issue the POST request
request.post(params,
   function (error, response, annotated_text) {
      if (!error && response.statusCode == 200) {
         // Process the annotated text
         console.log(annotated_text)
      }
   }
);
