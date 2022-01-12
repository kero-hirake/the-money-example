(ns the-money-example.core-test
  (:require [clojure.test :refer :all]
            [the-money-example.core :refer :all]))

(deftest money-test
  (testing "Dollarを掛け算すると、その結果が入った新しいDollarを返す"
   (testing "5 USD * 2 = 10 USD"
     (let [five (->Dollar 5)]
       (is (= (->Dollar 10) (times five 2)))))
    (testing "5 USD * 3 = 15 USD"
      (let [five (->Dollar 5)]
        (is (= (->Dollar 15) (times five 3))))))
  (testing "同じ金額の通貨は別オブジェクトでもイコール"
    (testing "5 USD = 5 USD"
      (is (= (->Dollar 5) (->Dollar 5))))
    (testing "5 USD != 6 USD"
      (is (not= (->Dollar 5) (->Dollar 6)))))
  (testing "Francを掛け算すると、その結果が入った新しいFrancを返す"
    (let [five (->Franc 5)]
      (is (= (->Franc 10) (times five 2)))
      (is (= (->Franc 15) (times five 3)))))
)
