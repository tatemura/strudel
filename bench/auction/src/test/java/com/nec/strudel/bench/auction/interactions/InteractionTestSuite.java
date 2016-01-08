/*******************************************************************************
 * Copyright 2015, 2016 Junichi Tatemura
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.nec.strudel.bench.auction.interactions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    SellAuctionItemTest.class,
    SellSaleItemTest.class,
    StoreAuctionBuyNowTest.class,
    StoreBidTest.class,
    StoreSaleBuyNowTest.class,
    ViewAuctionBidHistoryTest.class,
    ViewAuctionBuyNowTest.class,
    ViewAuctionItemTest.class,
    ViewAuctionItemsByBuyerTest.class,
    ViewAuctionItemsBySellerTest.class,
    ViewBidsByBidderTest.class,
    ViewSaleBuyNowHistoryTest.class,
    ViewSaleItemTest.class,
    ViewSaleItemsByBuyerTest.class,
    ViewSaleItemsBySellerTest.class,
    ViewUserTest.class,
    ViewWinningBidsByBidderTest.class,
})
public class InteractionTestSuite {

}
