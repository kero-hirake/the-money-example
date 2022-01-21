(ns the-money-example.money)

#_(defprotocol IMoney
  (eq [this object]))

(defn eq [this object]
          (= (:amount this) (:amount object)))
