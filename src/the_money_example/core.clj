(ns the-money-example.core
  (:gen-class))

(defprotocol Calc
  (times [this multiplier]))

(defn eq [obj1 obj2]
  ;{:pre [(instance? Calc obj1)]}
  (and
   (= (:amount obj1) (:amount obj2))
   (= (class obj1) (class obj2))))

(defrecord Dollar [amount]
  Calc
  (times [this multiplier]
    (->Dollar (* amount multiplier))))

(defrecord Franc [amount]
  Calc
  (times [this multiplier]
    (->Franc (* amount multiplier))))
