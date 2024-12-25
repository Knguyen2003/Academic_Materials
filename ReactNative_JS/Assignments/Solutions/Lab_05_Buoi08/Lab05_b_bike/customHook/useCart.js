import React, { createContext, useContext, useState, useMemo } from 'react';

// Chia se gio hang giua cac component
const CartContext = createContext();

// Custom hook để sử dụng context dễ dàng hơn
export const useCart = () => useContext(CartContext);

// CartProvider bao bọc toàn bộ ứng dụng và cung cấp giỏ hàng
export const CartProvider = ({ children }) => {
  const [cart, setCart] = useState([]);

  // Hàm thêm sản phẩm vào giỏ hàng
  const addToCart = (product) => {
    setCart((prevCart) => {
      const existingProduct = prevCart.find((item) => item.id === product.id);

      if (existingProduct) {
        return prevCart.map((item) =>
          item.id === product.id
            ? { ...item, quantity: item.quantity + 1 }
            : item
        );
      } else {
        return [...prevCart, { ...product, quantity: 1 }];
      }
    });
  };

  // Hàm giảm số lượng sản phẩm
  const decreaseQuantity = (productId) => {
    setCart((prevCart) =>
      prevCart
        .map((item) =>
          item.id === productId
            ? { ...item, quantity: item.quantity - 1 }
            : item
        )
        .filter((item) => item.quantity > 0) // Loại bỏ sản phẩm nếu số lượng bằng 0
    );
  };

  // Hàm xóa sản phẩm khỏi giỏ hàng
  const removeFromCart = (productId) => {
    setCart((prevCart) => prevCart.filter((item) => item.id !== productId));
  };

  // Tính tổng tiền giỏ hàng
  //useMemo giúp ghi nhớ các giá trị đã tính toán
  const totalAmount = useMemo(
    () =>
      cart.reduce((total, item) => total + item.price * item.quantity, 0),
    [cart]
  );

  return (
    <CartContext.Provider
      value={{ cart, addToCart, decreaseQuantity, removeFromCart, totalAmount }}
    >
      {children}
    </CartContext.Provider>
  );
};
