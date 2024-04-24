package dzwdz.chat_heads.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod("chat_heads")
public class ChatHeads {
	public ChatHeads(IEventBus modBus) {
		if (FMLEnvironment.dist == Dist.CLIENT) {
			ChatHeadsClient.init(modBus);
		}
	}
}
