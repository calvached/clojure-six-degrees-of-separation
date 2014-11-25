(ns six-degrees-of-separation.parser-test
  (:use midje.sweet)
  (:use [six-degrees-of-separation.parser]))

(facts "Parser"
  (fact "returns the sender name when given a string"
    (sender-name "duncan: @emily, oh what a pity. I'll fill you in next week.") => "duncan"
    (sender-name "diana: \"The spirit of x-mas is godzilla!\" #SpiritOfChristmas @twittertweet") => "diana"
    )

  (fact "returns the names of all the receivers in a message"
    (receiver-names "christie: 'Every day, men and women, conversing, beholding and beholden.' /cc @alberta, @bob") => '("alberta", "bob")
    (receiver-names "duncan: hey @farid and @bob") => '("farid", "bob")
    (receiver-names "bob: @duncan, @christie so I see it is Emerson tonight") => '("duncan", "christie")
    )

  (fact "returns a parsed tweet"
    (parse-tweet "bob: @duncan, @christie so I see it is Emerson tonight") =>
        { :sender "bob", :receivers '("duncan", "christie") }
    )
)
