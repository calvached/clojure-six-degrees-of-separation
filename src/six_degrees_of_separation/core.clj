(ns six-degrees-of-separation.core)

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
