(ns the-money-example.money)

(defprotocol IMoney
  (eq [this other])
  (times [this mulitplier])
  (plus [this other]))

(defrecord Money [amount currency]
  IMoney
  (eq [this other]
    (and
     (= (:amount this) (:amount other))
     (= (:currency this) (:currency other))))
  (times [this mulitplier]
    (->Money (* amount mulitplier) currency))
  (plus [this addend]
    (->Money (+ amount (:amount addend)) currency)))

(defn dollar [amount]
  (->Money amount :USD))

(defn franc [amount]
  (->Money amount :CHF))