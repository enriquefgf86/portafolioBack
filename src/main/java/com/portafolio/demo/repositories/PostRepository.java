package com.portafolio.demo.repositories;

import com.mongodb.client.result.UpdateResult;
import com.portafolio.demo.documents.Coments;
import com.portafolio.demo.documents.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Post savePost(Post post) {
        return mongoTemplate.save(post);
    }//salvando el post en el mongo template

    public UpdateResult addComment(String idPost, Coments commentAdded) {
        return mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("_id").is(idPost)), new Update().addToSet("allComments", commentAdded), Post.class);
    }//salvando los commnets enb el mongo template,aregadndo cometnarios

    public List<Post> findAllComments() {
        return mongoTemplate.findAll(Post.class);
    }//retornando todos los comentarios existentes de la colleccion de post


    public Post findPostById(String idPost) {
        return mongoTemplate.findById(idPost, Post.class);
    }

    public Post deletePostById(String idPost) {
        return mongoTemplate.findAndRemove(new Query().addCriteria(Criteria.where("_id").is(idPost)), Post.class);
    }

    public void updatePostById(String idPost, @RequestBody Post post) {
        Post postFound = mongoTemplate.findById(idPost, Post.class);

        if(!post.getDescription().isEmpty()){
            postFound.setDescription(post.getDescription());
        }


        if(!post.getName().isEmpty()){
            postFound.setName(post.getName());
        }
        if(!post.getTechnologies().isEmpty()){
            postFound.setTechnologies(post.getTechnologies());
        }

        if (!post.getImages().isEmpty()) {
            postFound.getImages().addAll(post.getImages());
        }

        if (!post.getVideos().isEmpty()) {
            postFound.setVideos(post.getVideos());
        }

        assert postFound != null;
        mongoTemplate.save(postFound);

    }

    public List<Post> searchPosts(String search) {

//        Query query= new Query(
//                new Criteria()
//                        .orOperator(
//                                Criteria.where("text").regex(search,"i"),
//                                Criteria.where("description").regex(search,"i"),
//                                Criteria.where("name").regex(search,"i")
//                        )
//        );
//        return mongoTemplate.find(query,Post.class);

        return mongoTemplate.aggregate(Aggregation.newAggregation(Aggregation.match(new Criteria().orOperator(

                Criteria.where("text").regex(search, "i"), Criteria.where("description").regex(search, "i"), Criteria.where("name").regex(search, "i"), Criteria.where("technologies").regex(search, "i")

        ))), "Post", Post.class).getMappedResults();
    }
}
