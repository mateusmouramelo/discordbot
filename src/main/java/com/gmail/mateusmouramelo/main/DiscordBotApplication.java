package com.gmail.mateusmouramelo.main;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public class DiscordBotApplication {

	public static void main(String[] args) {

		System.out.println("Olá bot!");

		final String token = args[0];
		final DiscordClient client = DiscordClient.create(token);
		final GatewayDiscordClient gateway = client.login().block();

		gateway.on(MessageCreateEvent.class).subscribe(event -> {
			final Message message = event.getMessage();
			if ("WillSmith".equals(message.getContent())) {
				final MessageChannel channel = message.getChannel().block();
				channel.createMessage("Sou Eu").block();
			}
		});

		gateway.onDisconnect().block();

	}

}
