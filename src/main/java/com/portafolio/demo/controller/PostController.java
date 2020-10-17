package com.portafolio.demo.controller;

import com.mongodb.client.result.UpdateResult;
import com.portafolio.demo.documents.Coments;
import com.portafolio.demo.documents.Post;
import com.portafolio.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://portafolio-angular-bucket.s3-website-us-west-2.amazonaws.com", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//@CrossOrigin(origins = "https://frontportafolio.herokuapp.com", maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("portafolio/version1")



public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post/all")
    public List<Post> getAllPost(){
        return postRepository.findAllComments();
    }

    @GetMapping("/post/get/{idPost}/selected")
    public Post getAPost(@PathVariable ("idPost") String idPost){
        return postRepository.findPostById(idPost);
    }

    @PostMapping("/post/create")
    public Post savePosts(@RequestBody Post postSaved){
        return postRepository.savePost(postSaved);

    }

    @DeleteMapping("/post/delete/{idPost}/post")
    public Post deleteAllThePosts(@PathVariable ("idPost") String idPost){
        return postRepository.deletePostById(idPost);

    }

    @GetMapping("/post/{search}/search")
    public List<Post> getSearchedPosts(@PathVariable ("search") String search){
        return postRepository.searchPosts(search);
    }

    @PostMapping("/post/{idPost}/add/comment")
    public UpdateResult adCoomentToPost(@PathVariable("idPost") String idPost,@RequestBody Coments commentAdded){
        return postRepository.addComment(idPost,commentAdded);

    }
}
