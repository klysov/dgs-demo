package com.example.dgsdemo;

import com.netflix.dgs.codgen.generated.types.Review;
import com.netflix.dgs.codgen.generated.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDataFetcher {

    private final List<Show> showData = List.of(
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
    public List<Show> shows(@InputArgument String titleFilter) {
        if (titleFilter != null) {
            return showData.stream()
                    .filter(s -> s.getTitle().startsWith(titleFilter))
                    .collect(Collectors.toList());
        }
        return showData;
    }
}
