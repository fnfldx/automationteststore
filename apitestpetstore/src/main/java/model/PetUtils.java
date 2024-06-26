package model;

import java.util.Arrays;
import java.util.Random;

import static model.Status.AVAILABLE;
import static java.lang.Math.abs;
import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;

public class PetUtils {
    private static final String PET_STATUS = AVAILABLE.toString().toLowerCase();

    public static Pet generatePetWithRandomTestData() {
        return createPet(idGenerator());
    }

    public static Pet generatePetWithRandomTestData(Long id) {
        return createPet(id);
    }

    private static Pet createPet(Long id) {
        return Pet.builder()
                .id(id)
                .category(Category.builder()
                        .id(idGenerator())
                        .name(nameGenerator()).build())
                .name(nameGenerator())
                .photoUrls(asList(urlGenerator(), urlGenerator()))
                .tags(Arrays.asList(Tag.builder()
                        .id(idGenerator())
                        .name(nameGenerator()).build()))
                .status(PET_STATUS)
                .build();
    }

    private static Long idGenerator() {
        return abs(new Random().nextLong());
    }

    private static String nameGenerator() {
        return randomUUID().toString();
    }

    private static String urlGenerator() {
        return "https://" + randomUUID() + ".com";
    }
}
