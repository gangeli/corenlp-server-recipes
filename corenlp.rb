require 'net/http'
require 'json'

uri = URI('https://corenlp.ai/')

Net::HTTP.start(uri.host, uri.port,
   :use_ssl => uri.scheme == 'https') do |http|

   # Create the request
   request = Net::HTTP::Post.new(uri.request_uri)
   request.body = 'the fox jumped over the lazy dog'
   request.basic_auth 'api_key', 'api_secret'

   # Issue the request
   response = http.request(request)

   # Parse the annotated text
   annotated_text = JSON.parse(response.body)
   puts annotated_text
end
