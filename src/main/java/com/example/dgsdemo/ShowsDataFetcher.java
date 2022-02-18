package com.example.dgsdemo;

import com.netflix.dgs.codgen.generated.types.Review;
import com.netflix.dgs.codgen.generated.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;

@DgsComponent
public class ShowsDataFetcher {

    private List<Show> showData = List.of(
            Show.newBuilder()
                    .title("Stranger Things")
                    .reviews(List.of(
                            Review.newBuilder().starScore(5).build()
                    ))
                    .build(),
            Show.newBuilder()
                    .title("Ozark")
                    .reviews(List.of(
                            Review.newBuilder().starScore(5).build()
                    ))
                    .build()
    );

    @DgsQuery
    public List<Show> shows() {
        return showData;
    }
}
