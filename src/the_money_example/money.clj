(ns the-money-example.money)

#_(defprotocol IMoney
  (eq [this object]))

(defn eq [this object]
  (and
   (= (:amount this) (:amount object))
   (= (class this) (class object))))
