(ns six-degrees-of-separation.parser)

(defn sender-name [tweet]
  (re-find #"\A\w+" tweet)
  )

(defn receiver-names [tweet]
  (re-seq #"(?<=@)\w+" tweet)
  )

(defn parse-tweet [tweet]
  {
   :sender (sender-name tweet),
   :receivers (receiver-names tweet)
   }
  )
