package model;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Getter
@Builder
@FieldNameConstants
@RequiredArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class Category {

    public final Long id;
    public final String name;
}
