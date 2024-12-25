import React from 'react';
import { View, Text, Button, StyleSheet, FlatList, TouchableOpacity } from 'react-native';

const AdminScreen = ({ navigation }) => {
  const navigateToListBikes = () => {
    navigation.navigate('Screen2'); // Tạo trang "ManageBikes" riêng
  };

  const navigateToAddBike= () => {
    navigation.navigate('AddBike'); // Tạo trang "ManageUsers" riêng
  };

  return (
    <View style={styles.container}>
      <Text style={styles.header}>Admin Dashboard</Text>

      <TouchableOpacity style={styles.button} onPress={navigateToListBikes}>
        <Text style={styles.buttonText}>DANH SÁCH XE ĐẠP</Text>
      </TouchableOpacity>

      <TouchableOpacity style={styles.button} onPress={navigateToAddBike}>
        <Text style={styles.buttonText}>THÊM XE ĐẠP</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  header: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
  },
  button: {
    padding: 15,
    backgroundColor: '#007AFF',
    borderRadius: 8,
    marginVertical: 10,
    width: '80%',
    alignItems: 'center',
  },
  buttonText: {
    color: 'white',
    fontSize: 16,
    fontWeight: 'bold',
  },
});

export default AdminScreen;
