package Design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class AuctionSystem {

    // Map: itemid -> (bidAmount, treeset of userIds)
    private Map<Integer, TreeMap<Integer, TreeSet<Integer>>> itemBids;

    // Map: itemid -> (userId, currentBid)
    private Map<Integer, Map<Integer, Integer>> userBids;


    public AuctionSystem() {
        itemBids = new HashMap<>();
        userBids = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        if (userBids.containsKey(itemId) && userBids.get(itemId).containsKey(userId)) {
            removeBid(userId, itemId);
        }

        userBids.putIfAbsent(itemId, new HashMap<>());
        itemBids.putIfAbsent(itemId, new TreeMap<>());

        userBids.get(itemId).put(userId, bidAmount);
        itemBids.get(itemId).putIfAbsent(bidAmount, new TreeSet<>());
        itemBids.get(itemId).get(bidAmount).add(userId);

    }

    public void updateBid(int userId, int itemId, int newAmount) {
        addBid(userId, itemId, newAmount);
    }

    public void removeBid(int userId, int itemId) {
        if (!userBids.containsKey(itemId) || !userBids.get(itemId).containsKey(userId)) {
            return;
        }

        int amount = userBids.get(itemId).remove(userId);
        TreeSet<Integer> usersAtAmt = itemBids.get(itemId).get(amount);
        usersAtAmt.remove(userId);

        if (usersAtAmt.isEmpty()) {
            itemBids.get(itemId).remove(amount);
        }
    }

    public int getHighestBidder(int itemId) {
        if (!itemBids.containsKey(itemId) || itemBids.get(itemId).isEmpty()) {
            return -1;
        }

        TreeMap<Integer, TreeSet<Integer>> bids = itemBids.get(itemId);
        int highest = bids.lastKey();

        return bids.get(highest).last();
    }


    public static void main(String[] args) {
        AuctionSystem obj = new AuctionSystem();
        obj.addBid(1, 1, 20);
        obj.updateBid(1, 1, 10);
//        obj.removeBid(1, 1);
        int param_4 = obj.getHighestBidder(1);
        System.out.println(param_4);
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */