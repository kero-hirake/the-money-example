(ns the-money-example.core-test
  (:require [clojure.test :refer :all]
            [the-money-example.core :refer :all]))

(deftest money-test
  (testing "Dollarを掛け算すると、その結果が入った新しいDollarを返す"
    (testing "5 USD * 2 = 10 USD"
      (let [five (->Money 5 :USD)]
        (is (eq (->Money 10 :USD) (times five 2)))))
    (testing "5 USD * 3 = 15 USD"
      (let [five (->Money 5 :USD)]
        (is (eq (->Money 15 :USD) (times five 3))))))
  (testing "同じ金額の通貨は別オブジェクトでもイコール"
    (testing "5 USD = 5 USD"
      (is (eq (->Money 5 :USD) (->Money 5 :USD))))
    (testing "5 USD != 6 USD"
      (is (not (eq (->Money 5 :USD) (->Money 6 :USD)))))
    (testing "5 CHF != 5 USD"
      (is (not (eq (->Money 5 :CHF) (->Money 5 :USD))))))
  (testing "通貨のテスト"
    (testing "Dollarの通貨は:USD"
      (is (= (:currency (->Money 1 :USD)) :USD)))
    (testing "Francの通貨は:CHF"
      (is (= (:currency (->Money 1 :CHF)) :CHF))))
  )
