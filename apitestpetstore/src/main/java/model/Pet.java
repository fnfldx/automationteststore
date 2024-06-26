package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Getter
@Builder
@FieldNameConstants
@RequiredArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class Pet {

    public final Long id;
    public final Category category;
    public final String name;
    public final List<String> photoUrls;
    public final List<Tag> tags;
    public final String status;
}
