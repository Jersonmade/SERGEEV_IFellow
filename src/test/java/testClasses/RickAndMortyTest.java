package testClasses;

import ru.iFellow.apiSteps.FirstTaskStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ConfProperties;
import webhooks.WebHooks;

import static ru.iFellow.apiSteps.FirstTaskStep.*;

public class RickAndMortyTest extends WebHooks {

    @Test
    public void testSpeciesAndLocation() {
        FirstTaskStep firstTaskStep = new FirstTaskStep();

        firstTaskStep.getCharacter(
                ConfProperties.getProperty("morty.base.uri"),
                ConfProperties.getProperty("morty.get.morty.uri"),
                Integer.parseInt(ConfProperties.getProperty("get.status.code"))
        );
        firstTaskStep.getIdLastCharacterFromLastEpisode(
                ConfProperties.getProperty("morty.base.uri"),
                Integer.parseInt(ConfProperties.getProperty("get.status.code"))
        );
        firstTaskStep.getLocationAndSpeciesLastCharacter(
                ConfProperties.getProperty("morty.base.uri"),
                Integer.parseInt(ConfProperties.getProperty("get.status.code"))
        );

        Assertions.assertEquals(speciesMorty, speciesLastCharacter);
        Assertions.assertFalse(Boolean.parseBoolean(locationNameMorty), locationNameLastCharacter);
    }

}
