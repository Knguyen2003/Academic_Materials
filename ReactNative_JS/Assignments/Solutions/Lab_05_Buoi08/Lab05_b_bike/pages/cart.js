import React from 'react';
import { View, Text, Button, FlatList, StyleSheet, Image, TouchableOpacity } from 'react-native';
import { useCart } from '../customHook/useCart'; // Import hook useCart

const CartScreen = () => {
  const { cart, removeFromCart, addToCart, decreaseQuantity, totalAmount } = useCart(); // Thêm các hàm cần thiết

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Giỏ hàng</Text>
      {cart.length === 0 ? (
        <Text style={styles.emptyCart}>Giỏ hàng trống</Text>
      ) : (
        <>
          <FlatList
            data={cart}
            keyExtractor={(item) => item.id.toString()}
            renderItem={({ item }) => (
              <View style={styles.item}>
                <Image source={{ uri: item.image }} style={styles.image} />
                <View style={styles.itemDetails}>
                  <Text style={styles.itemName}>{item.name}</Text>
                  <Text style={styles.itemPrice}>{item.price} VND</Text>
                  <View style={styles.quantityContainer}>
                    <TouchableOpacity onPress={() => decreaseQuantity(item.id)}>
                      <Text style={styles.quantityButton}>-</Text>
                    </TouchableOpacity>
                    <Text style={styles.quantity}>{item.quantity}</Text>
                    <TouchableOpacity onPress={() => addToCart(item)}>
                      <Text style={styles.quantityButton}>+</Text>
                    </TouchableOpacity>
                  </View>
                </View>
                <Button
                  title="Xóa"
                  onPress={() => removeFromCart(item.id)}
                  color="red"
                />
              </View>
            )}
          />
          <Text style={styles.totalAmount}>
            Tổng tiền: {totalAmount} VND
          </Text>
        </>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20, backgroundColor: '#f8f9fa' },
  title: { fontSize: 28, fontWeight: 'bold', marginBottom: 15, color: '#333' },
  emptyCart: { textAlign: 'center', fontSize: 18, marginTop: 50, color: '#888' },
  item: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#fff',
    marginBottom: 15,
    borderRadius: 10,
    padding: 10,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 5,
  },
  image: { width: 80, height: 80, borderRadius: 10, marginRight: 10 },
  itemDetails: { flex: 1 },
  itemName: { fontSize: 18, fontWeight: 'bold', color: '#333' },
  itemPrice: { fontSize: 16, color: '#888', marginTop: 5 },
  quantityContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginTop: 10,
  },
  quantityButton: {
    fontSize: 24,
    paddingHorizontal: 10,
    fontWeight: 'bold',
    color: '#333',
  },
  quantity: { fontSize: 18, marginHorizontal: 10 },
  totalAmount: {
    fontSize: 22,
    fontWeight: 'bold',
    textAlign: 'center',
    marginTop: 10,
    color: '#333',
  },
});

export default CartScreen;
