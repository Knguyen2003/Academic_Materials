import React, { useState } from 'react';
import {
  View,
  Text,
  FlatList,
  Image,
  StyleSheet,
  TextInput,
} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

const DATA = [
  {
    id: '1',
    image: require('./assets/carbusbtops21.png'),
    title: 'Cáp chuyển từ Cổng USSB Sang PS2...',
    shop: 'Devang',
    price: '69.900đ',
    quantity: '(15)',
    discount: '39%',
  },
  {
    id: '2',
    image: require('./assets/daucam1.png'),
    title: 'Cáp chuyển từ Cổng USB Sang PS2 ...',
    shop: 'Devang',
    price: '69.900đ',
    quantity: '(15)',
    discount: '39%',
  },
  {
    id: '3',
    image: require('./assets/dauchuyendoi1.png'),
    title: 'Cáp chuyển từ Cổng USB Sang PS2 ...',
    shop: 'Devang',
    price: '69.900đ',
    quantity: '(15)',
    discount: '39%',
  },
  {
    id: '4',
    image: require('./assets/dauchuyendoipsps21.png'),
    title: 'Cáp chuyển từ Cổng USB Sang PS2 ...',
    shop: 'Devang',
    price: '69.900đ',
    quantity: '(15)',
    discount: '39%',
  },
  {
    id: '5',
    image: require('./assets/daynguon1.png'),
    title: 'Cáp chuyển từ Cổng USB Sang PS2 ...',
    shop: 'Devang',
    price: '69.900đ',
    quantity: '(15)',
    discount: '39%',
  },
  {
    id: '6',
    image: require('./assets/giacchuyen1.png'),
    title: 'Cáp chuyển từ Cổng USB Sang PS2 ...',
    shop: 'Devang',
    price: '69.900đ',
    quantity: '(15)',
    discount: '39%',
  },
  {
    id: '7',
    image: require('./assets/dauchuyendoipsps21.png'),
    title: 'Cáp chuyển từ Cổng USB Sang PS2 ...',
    shop: 'Devang',
    price: '69.900đ',
    quantity: '(15)',
    discount: '39%',
  },
  {
    id: '8',
    image: require('./assets/daucam1.png'),
    title: 'Cáp chuyển từ Cổng USB Sang PS2 ...',
    shop: 'Devang',
    price: '69.900đ',
    quantity: '(15)',
    discount: '39%',
  },
];

//Tạo cái view của từng item trong data
const ItemView = ({ item }) => {
  return (
    <View style={styles.itemView}>
      <Image source={item.image} style={styles.img} />
      <Text>{item.title} </Text>

      <View style={{ flexDirection: 'row' }}>
        <Image
          source={require('./assets/Star4.png')}
          style={{ height: 20, width: 20 }}
        />
        <Image
          source={require('./assets/Star4.png')}
          style={{ height: 20, width: 20 }}
        />
        <Image
          source={require('./assets/Star4.png')}
          style={{ height: 20, width: 20 }}
        />
        <Image
          source={require('./assets/Star4.png')}
          style={{ height: 20, width: 20 }}
        />
        <Image
          source={require('./assets/Star5.png')}
          style={{ height: 20, width: 20 }}
        />
        <Text>{item.quantity} </Text>
      </View>
      <View style={styles.priceDiscount}>
        <Text style={styles.price}>{item.price} </Text>
        <Text>{item.discount} </Text>
      </View>
    </View>
  );
};

const YourApp = () => {
  //Tạo use state
  const [listItems, setListItems] = useState(DATA);
  const [searchQuery, setSearchQuery] = useState('');
  return (
    <View style={{ flex: 1 }}>
      <View style={styles.header}>
        <Icon name="chevron-left" size={30} color="white" />
        <View style={styles.searchContainer}>
          <Icon name="search" size={20} color="#000" style={{marginRight:5}} />
          <TextInput
            style={styles.input}
            placeholder="Dây cáp USB"
            placeholderTextColor="#888"
            value={searchQuery}
            onChangeText={(text) => setSearchQuery(text)}
          />
        </View>
        <Icon name="shopping-cart" size={30} color="white" />
        <Icon name="ellipsis-h" size={30} color="white"/>
      </View>
      <View style={styles.center}>
        <FlatList
          data={listItems}
          renderItem={ItemView}
          keyExtractor={(item) => item.id}
          numColumns={2}
        />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  header: {
    flex: 1,
    backgroundColor: '#1aa7ff',
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingTop: 50,
    paddingHorizontal: 20,
  },
  searchContainer: {
    flexDirection: 'row',
    width:170,
    alignItems: 'center',
    backgroundColor: 'white',
    padding: 10,
  },
  input: {
    flex: 1,
    fontSize: 16,
    color :'black',
  },
  center: {
    flex: 9,
    backgroundColor: '#e5e5e5',
    width: '100%',
    padding: 10,
  },
  itemView: {
    flex: 1,
    alignItems: 'center',
    width: '45%',
    alignItems: 'flex-start',
    margin: 10,
  },
  img: {
    width: '100%',
    height: 120,
    resizeMode: 'contain',
  },
  priceDiscount: {
    flexDirection: 'row',
  },
  price: {
    fontWeight: 'bold',
    marginRight: 10,
  },
});

export default YourApp;
