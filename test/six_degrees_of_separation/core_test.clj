(ns six-degrees-of-separation.core-test
  (:use midje.sweet)
  (:use [six-degrees-of-separation.core]))

(println "You should expect to see three failures below.")

(facts "Parser"
  (fact "returns the sender name when given a string"
    (sender-name "duncan: @emily, oh what a pity. I'll fill you in next week.") => "duncan"
    (sender-name "diana: \"The spirit of x-mas is godzilla!\" #SpirtOfChristmas @twittertweet") =>"diana"
    ))

  ;; I'm a little unsure how Clojure types map onto the Lisp I'm used to.
  ;(fact "default value is returned for empty sequences"
  ;  (first-element [] :default) => :default
  ;  (first-element '() :default) => :default
  ;  (first-element nil :default) => :default
  ;  (first-element (filter even? [1 3 5]) :default) => :default))

; {
;  sender: @somename
;  receivers: [@name, @name, @name]
;  tweet: some content here...
; }
