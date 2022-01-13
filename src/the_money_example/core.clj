(ns the-money-example.core
  (:gen-class))

(defprotocol Calc
  (times [this multiplier])
  (eq [this object]))

(defrecord Dollar [amount]
  Calc
  (times [this multiplier]
    (->Dollar (* amount multiplier)))
  (eq [this object]
    (and
     (= amount (:amount object))
     (= (class this) (class object)))))

(defrecord Franc [amount]
  Calc
  (times [this multiplier]
    (->Franc (* amount multiplier)))
  (eq [this object]
      (and
       (= amount (:amount object))
       (= (class this) (class object))))
  )
