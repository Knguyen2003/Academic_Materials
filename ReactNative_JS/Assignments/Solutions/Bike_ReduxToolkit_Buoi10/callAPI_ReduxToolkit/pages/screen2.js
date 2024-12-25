import React, { useState, useEffect } from 'react';
import { View, Text, FlatList, Image, TouchableOpacity, StyleSheet, ActivityIndicator } from 'react-native';
import { MaterialIcons } from '@expo/vector-icons';
import { useDispatch, useSelector } from 'react-redux';
import { fetchBikes } from '../redux_toolkit/slice';  // import action ays trong slice


const categories = ['All', 'Roadbike', 'Mountain'];



const getImage = (imagePath) => {
  switch (imagePath) {
    case 'image1':
      return require('../assets/bione-removebg-preview.png');
    case 'image2':
      return require('../assets/bitwo-removebg-preview.png');
    case 'image3':
      return require('../assets/bithree_removebg-preview.png');
    case 'image4':
      return require('../assets/bifour_-removebg-preview.png');
    default:
      return require('../assets/bione-removebg-preview.png');
  }
};

const Screen2 = ({ navigation }) => {
  /*Dùng để lọc theo danh mục */
  const [selectedCategory, setSelectedCategory] = useState('All');

  const dispatch = useDispatch();
  const bike = useSelector((state) => state.bikes.bikes);
  const status = useSelector((state) => state.bikes.status);
  const error = useSelector((state) => state.bikes.error);
  
   /*CHUYEN MAN HINH */
  const chuyen = (item) =>{
      navigation.navigate('Screen3', { bike: item })
  };

 const filteredBikes = bike.filter(bike => selectedCategory === 'All' ? true : bike.category === selectedCategory)


  useEffect(() => {
    if (status === 'idle') {
      dispatch(fetchBikes());
    }
  }, [status, dispatch]);

  if (status === 'loading') return <Text>Loading...</Text>;
  if (status === 'failed') return <Text>Error: {error}</Text>;


  const hienThi = ({item}) =>{
    return (
        <TouchableOpacity
            style={styles.bikeCard}
            onPress={()=>{chuyen(item)}}
          >
            <MaterialIcons
              name="favorite"
              size={24}
              color={item.heart ? 'red' : 'gray'}
              style={styles.heartIcon}
            />
            <Image source={getImage(item.image)} style={styles.bikeImage} />
            <Text style={styles.bikeName}>{item.name}</Text>
            <Text style={styles.bikePrice}>$ {item.price}</Text>
        </TouchableOpacity>
    );
  };

  return (
    <View style={styles.container}>
      <Text style={styles.header}>The world's Best Bike</Text>

      <View style={styles.filterContainer}>
        {categories.map((category) => (
          <TouchableOpacity
            key={category}
            style={styles.filterButton}
            onPress={() => setSelectedCategory(category)}
          >
            <Text style={[
              styles.filterButtonText,
              /*Nếu bên trái là "true" thì bên phải được làm và ngược lại*/
              selectedCategory === category && styles.activeFilterButton,
            ]}>
              {category}
            </Text>
          </TouchableOpacity>
        ))}
      </View>

      {/* Hiển thị danh sách xe đạp */}
        <FlatList
           data={filteredBikes}
           keyExtractor={(item) => item.id}
           renderItem={hienThi}
           numColumns={2}
           columnWrapperStyle = {styles.row}
         />
      
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
  },
  header: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 10,
    color: 'red',
  },
  filterContainer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    marginBottom: 10,
  },
  filterButton: {
    padding: 10,
    backgroundColor: '#f0f0f0',
    borderRadius: 5,
    borderWidth: 1,
    borderColor: 'pink',
    width :100,
  },
  activeFilterButton: {
    color: 'red',
  },
  filterButtonText: {
    fontSize: 14,
    color: '#bbbbbb',
    textAlign :'center',
    fontWeight :'bold'
  },
  bikeCard: {
    flex: 1,
    margin: 10,
    backgroundColor: '#E941411A',
    borderRadius: 10,
    padding: 10,
    alignItems: 'center',
    position: 'relative',
  },
  heartIcon: {
    position: 'absolute',
    top: 10,
    left: 10,
  },
  bikeImage: {
    width: 120,
    height: 150,
    borderRadius: 10,
    marginBottom: 10,
    resizeMode: 'contain',
  },
  bikeName: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  bikePrice: {
    fontSize: 14,
    color: 'black',
  },
});

export default Screen2;