import 'package:flutter_05_api_rest_app/models/post.dart';
import 'package:http/http.dart' as http;

class PostService {
  // Obtengo los valores del API REST
  Future<List<Post>?> getPosts() async {
    var client = http.Client();

    var uri = Uri.parse('https://jsonplaceholder.typicode.com/posts');
    var response = await client.get(uri);

    if (response.statusCode == 200) {
      var json = response.body;
      return postFromJson(json);
    }
  }
}
