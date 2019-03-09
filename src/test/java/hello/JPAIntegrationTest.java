package hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JPAIntegrationTest {

    @Autowired
    private ChannelRepository channelRepository;

    @Test
    public void givenChannelRepository_whenSaveAndRetreiveEntity_thenOK() {
        Channel channel = channelRepository.save(new Channel(1L, "12431234sas"));
        Channel foundEntity = channelRepository.findByChannelId(channel.getChannelId());

        Assert.assertNotNull(foundEntity);
        Assert.assertEquals(channel.getChannelId(), foundEntity.getChannelId());
    }
}
