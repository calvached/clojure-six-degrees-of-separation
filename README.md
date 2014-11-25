# [[#14] Six Degrees of Separation](http://www.puzzlenode.com/puzzles/14-six-degrees-of-separation)

_This puzzle was contributed by Andrea Singh and Gregory Brown and published on November 15, 2011_

The CEO of ABC Widgets Corp. has been concocting a new startup idea for a while now. He is of the opinion that the Twitter recommendation engine is deeply flawed, mainly because it seems to focus on the "follower" concept rather than conversations. Convinced that conversations are a better indicator of social connectedness, he sees a sure-win business opportunity in building a Twitter client that can "discover" social networks - and thus generate more informed recommendations on who to follow - based on a stream of Twitter conversations.

To help drum up some venture capital, you've been hired to quickly build out a proof of concept. Not to worry, you will be generously compensated for your time with stock options

## The Proof of Concept

You will need to parse an input file containing a number of tweets and construct the underlying social network based on who has talked to whom.

## The "Social Network"

The goal is to depict the social network you've uncovered by listing all active Twitter users in alphabetical order, directly followed by their respective social connections.

### What Is a "Connection"?

Connections between users are drawn based on conversations (or "mutual mentions" in the Twitter sense) and are classified according to their degree of proximity.

A direct or first order connection exists between two users if they both have had at least one tweet that mentions the other. For example, there is a direct connection between A and B if A mentions B and B mentions A. However, there would be no first order connection if A mentions B, but B doesn't mention A. So one-way mentions can be treated as "noise" and ignored altogether.

If A has a first order connection with B and B has a first order connection with C, then A has a second order connection with C. In a similar vein, there can be third, fourth, fifth, etc. order connections.

## The Input File

The input file contains a number of tweet-like messages separated by line breaks. Every tweet begins with the username of the sender, followed directly by a colon and then by the content of the tweet. The tweet itself will in many cases mention one or more Twitter users.

### Some Example Tweets

```
alberta: hey @christie. what will we be reading at the book club meeting tonight?
```

The person who sent this tweet is `alberta` and she mentions one other Twitter user, `@christie`. Mentions are always preceded by an `@`-symbol. Twitter usernames can contain alphanumeric characters and underscores.

Tweets can contain multiple mentions and can occur anywhere in the tweet. Typically, mentions will be at the beginning, as in the example tweet above. Mentions can also occur at the end, like so:

```
christie: "Every day, men and women, conversing, beholding and beholden..." /cc @alberta, @bob
```

## The Output File

As mentioned above, the output file should contain all __active__ Twitter users - i.e. users who have tweeted at least once - in alphabetical order. Each of these active users should be directly followed by their social connections. The first, second, third, etc. order connections should be grouped on separate lines and the names within each group should be listed in alphabetical order.

To illustrate how to plot these connections, let's consider an input file with these tweets:

```
alberta: @bob "It is remarkable, the character of the pleasure we derive from the best books."
bob: "They impress us ever with the conviction that one nature wrote and the same reads." /cc @alberta
alberta: hey @christie. what will we be reading at the book club meeting tonight?
christie: "Every day, men and women, conversing, beholding and beholden..." /cc @alberta, @bob
bob: @duncan, @christie so I see it is Emerson tonight
duncan: We'll also discuss Emerson's friendship with Walt Whitman /cc @bob
alberta: @duncan, hope you're bringing those peanut butter chocolate cookies again :D
emily: Unfortunately, I won't be able to make it this time /cc @duncan
duncan: @emily, oh what a pity. I'll fill you in next week.
christie: @emily, "Books are the best of things, well used; abused, among the worst." -- Emerson
emily: Ain't that the truth /cc @christie
duncan: hey @farid, can you pick up some of those cookies on your way home?
farid: @duncan, might have to work late tonight, but I'll try
```

Based on the mentions, we can identify the following first order connections:

```
alberta <--> bob
alberta <--> christie
bob <--> duncan
christie <--> bob
duncan <--> emily
emily <--> christie
farid <--> duncan
```

Seeing that the output list has to be alphabetical, let's begin with alberta's connections.

Alberta has had direct conversations with bob and christie. Note that even though alberta has mentioned duncan once, duncan has never mentioned alberta, so there is no direct connection between them.

Besides having had conversations with alberta, bob has talked to duncan and christie. Christie has had conversations with alberta, bob and emily. As a result, duncan and emily are alberta's second order connections.

Note that even though bob and christie have had a two-way conversation of their own, they should not be added as second order connections, since they have already been included as first order ones. In other words, a connection should only be listed once and the nearest connection takes precedence.

Moving on. Since emily has only ever talked to duncan and christie, there are no new connections added through her. Duncan, however, brings in farid as a 3rd order connection.

The output for alberta should then look as follows:

```
alberta
bob, christie
duncan, emily
farid
```

Continuing in alphabetical order, we would then need to plot the connections for bob, then for christie, and so on. The final output file then would look like this:

```
alberta
bob, christie
duncan, emily
farid

bob
alberta, christie, duncan
emily, farid

christie
alberta, bob, emily
duncan
farid

duncan
bob, emily, farid
alberta, christie

emily
christie, duncan
alberta, bob, farid

farid
duncan
bob, emily
alberta, christie

```

Notice that even with a relatively small number of users and tweets it is quite difficult to work out the higher order social connections manually.

You can test out your code with the `sample_input.txt` input file, which contains the same tweets as in the example we walked through above. The correct output for this sample can be found in `sample_output.txt`.

The input file you need to actually use to solve this puzzle is called `complex_input.txt`.
