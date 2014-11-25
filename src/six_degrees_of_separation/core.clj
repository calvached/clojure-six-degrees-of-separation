(ns six-degrees-of-separation.core)

(defn sender-name [tweet]
  (re-find (re-matcher #"\A\w+" tweet))
  )

(defn first-element [sequence default]
  (if (nil? sequence)
    default
    (first sequence)))
