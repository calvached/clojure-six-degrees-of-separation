(ns six-degrees-of-separation.core)

(defn sender-name [tweet]
  (re-find (re-matcher #"\A\w+" tweet))
  )

(defn receiver-names [tweet]
  (re-seq #"@\w+" tweet)
  )
