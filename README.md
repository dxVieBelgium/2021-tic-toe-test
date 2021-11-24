# 2021-tic-toe-test
This is a reproduction of the tictactoe game built with spring-boot, java version: 11, maven 3.6.3

## How to launch the project ?
First of all pull the project on your local machine with `git clone https://github.com/dxVieBelgium/2021-tic-toe-test.git`

Then, to be sure you are up to date run the following command inside the project `git pull --rebase origin master`

If everything is good you can go inside the folder "2021-tic-toe-test/" and run the commands: `mvn clean` then `mvn install`

Once the two previous command goes well you can launch `mvn spring-boot:run`


## How to play ?

In order to test it with more ease, i recommend you to use postman, you can also launch request with curl command line.

### Create a new game:

![image](https://user-images.githubusercontent.com/94607643/142997951-5c4e6b13-a0ce-4fb1-a4f4-f1aa771a5e6f.png)

1. The server run on port 8080 on your local machine and the endpoint is `/game/start`
2. The http verb is `POST`
3. Put a body for this request which is a raw JSON with key `login` and the value is your name as a player

Once you finished you can launch the request by click on the right button with the label `send`

As you can each response of the request is a json: <br />
```json
{
    "gameId": "19eace5d-6089-4a15-9e8a-f0ff7fe47172",
    "player1": {
        "login": "storm"
    },
    "player2": null,
    "status": "NEW",
    "board": [
        [
            0,
            0,
            0
        ],
        [
            0,
            0,
            0
        ],
        [
            0,
            0,
            0
        ]
    ],
    "winner": null
}
```

### Connect a second player to a Game: <br />
The process is the same as the previous step, you have to create a new request with the endpoint `/game/connect` <br />
And provide a body which is the login of the second and the `gameId` of the game you want to join in.

![image](https://user-images.githubusercontent.com/94607643/143002038-e3c24c60-0c1d-43ee-a638-16f78a8ab30c.png)

### Made a move:

Make a POST request with the endpoint `/game/gameplay` and provide a body with the data
- `type` which player you are (player1: X, player2: O).
- `coordinateX & coordinateY` position where you want to move.
- `gameId` the game where you play.

![image](https://user-images.githubusercontent.com/94607643/143007809-e36cc998-fe59-4405-a5c5-3fab396f4233.png)


