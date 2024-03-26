package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum MainPageSectionId {
    LATEST("latest"),
    BESTSELLER("bestseller"),
    SPECIAL("special");

    private final String id;
}