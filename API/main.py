from flask import Flask
import discord

MC_channel = 0;
Token = ""

app = Flask(__name__)
client = discord.Client(intents=discord.Intents.all())

@app.route('/message/<message>/<author>', methods=['POST'])
async def message(message, author):
    try:
        await send_api_post(message=message, author=author)
        return {"response": 200}
    except:
        return {"response": 500}

async def send_api_post(message, author):
    channel = client.get_channel(MC_channel)
    await channel.send(f"Message: {message} | Author: {author}")

if __name__ == "__main__":
    app.run()
    client.run(token=Token)

