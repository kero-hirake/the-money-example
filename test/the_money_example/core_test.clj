(ns the-money-example.core-test
  (:require [clojure.test :refer :all]
            [the-money-example.money :as money]
            [the-money-example.bank :as bank]))

(deftest money-test
  (testing "掛け算"
    (testing "5 USD * 2 = 10 USD"
      (let [five (money/dollar 5)]
        (is (= (money/dollar 10) (money/times five 2)))))
    (testing "5 USD * 3 = 15 USD"
      (let [five (money/dollar 5)]
        (is (= (money/dollar 15) (money/times five 3))))))
  (testing "等価性比較"
    (testing "5 USD = 5 USD"
      (is (money/eq (money/dollar 5) (money/dollar 5))))
    (testing "5 USD != 6 USD"
      (is (not (money/eq (money/dollar 5) (money/dollar 6)))))
    (testing "5 CHF != 5 USD"
      (is (not (money/eq (money/franc 5) (money/dollar 5))))))
  (testing "通貨"
    (testing "1 USD の通貨は :USD"
      (is (= :USD (:currency (money/dollar 1)))))
    (testing "1 CHF の通貨は :CHF"
      (is (= :CHF (:currency (money/franc 1))))))
  (testing "足し算"
    (testing "5 USD + 5 USD = 10 USD"
      (let [usd5 (money/dollar 5)
            sum (money/plus usd5 usd5)
            bank (bank/->Bank)
            redu (bank/redu bank sum :USD)]
        (is (= (money/dollar 10) redu)))
      (let [sum (money/plus (money/dollar 5) (money/dollar 5))]
        (is (= (money/dollar 10) sum))))
    )
  )
