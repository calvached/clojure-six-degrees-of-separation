(ns six-degrees-of-separation.core)

;;; This is an incorrect implementation, such as might be written by
;;; someone who was used to a Lisp in which an empty list is equal to
;;; nil.
(defn get-sender-name [tweet]
  (println tweet)
  )

(defn first-element [sequence default]
  (if (nil? sequence)
    default
    (first sequence)))
