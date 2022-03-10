package com.book.aws.domain.posts;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanUP() {
        postsRepository.deleteAll();
    }

    @Test
    public void savePostsTest() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "테스트 작성자";
        postsRepository.save(Posts
                .builder()
                .title(title)
                .content(content)
                .author(author)
                .build()
        );
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo(author);
    }
}