package com.example.dgsdemo;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {DgsAutoConfiguration.class, ShowsDataFetcher.class})
public class ShowsDataFetcherTest {

    @Autowired
    DgsQueryExecutor queryExecutor;

    @Test
    void shows() {
        List<String> shows = queryExecutor.executeAndExtractJsonPath("query {\n" +
                "  shows(titleFilter: \"Oz\") {\n" +
                "    title\n" +
                "  }\n" +
                "}", "data.shows[*].title");
        Assertions.assertThat(shows).containsExactly("Ozark");
    }
}
