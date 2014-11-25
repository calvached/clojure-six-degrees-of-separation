(ns six-degrees-of-separation.core-test
  (:use midje.sweet)
  (:use [six-degrees-of-separation.core]))

(facts "Core"
  (fact "runs a test"
    (+ 2 3) => 5
    )
)
