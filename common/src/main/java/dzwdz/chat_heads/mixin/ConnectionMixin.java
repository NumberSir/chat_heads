package dzwdz.chat_heads.mixin;

import dzwdz.chat_heads.ChatHeads;
import net.minecraft.network.Connection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

@Mixin(Connection.class)
public abstract class ConnectionMixin {
    // note: can run on different threads
    @Inject(method = "connectToServer", at = @At("HEAD"))
    private static void chatheads$resetServerKnowledge(InetSocketAddress inetSocketAddress, boolean bl, CallbackInfoReturnable<Connection> cir) {
        // reset every time we build a multiplayer connection
        ChatHeads.serverSentUuid = false;
        ChatHeads.serverDisabledChatHeads = false;
    }

    // note: can run on different threads
    @Inject(method = "connectToLocalServer", at = @At("HEAD"))
    private static void chatheads$resetServerKnowledgeSP(SocketAddress socketAddress, CallbackInfoReturnable<Connection> cir) {
        // reset every time we build a singleplayer connection
        ChatHeads.serverSentUuid = false;
        ChatHeads.serverDisabledChatHeads = false;
    }
}