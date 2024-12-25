import React, { useState } from 'react';
import {
  Text,
  SafeAreaView,
  View,
  TextInput,
  TouchableOpacity,
  FlatList,
  Image,
} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import styles from './components/style';

//Tạo dữ liệu mẫu Donut
const donutsData = [
  {
    id: 1,
    name: 'Tasty Donut',
    price: '$10.00',
    image: require('./assets/donut_red1.png'),
    description: 'Spicy tasty donut family',
    category: 'Donut',
  },
  {
    id: 2,
    name: 'Pink Donut',
    price: '$20.00',
    image: require('./assets/green_donut1.png'),
    description: 'Sweet pink donut',
    category: 'Pink Donut',
  },
  {
    id: 3,
    name: 'Floating Donut',
    price: '$30.00',
    image: require('./assets/tasty_donut1.png'),
    description: 'Floating donut in the air',
    category: 'Floating',
  },
  {
    id: 4,
    name: 'Tasty Donut',
    price: '$10.00',
    image: require('./assets/donut_yellow1.png'),
    description: 'Delicious donut',
    category: 'Donut',
  },
];
//Trang 1
const Home = ({ navigation }) => {
  //Input
  const [food, setFood] = useState('');
  //Nút : set màu để chuyển (mặc định nút đầu được nhấn)
  const [selectedButton, setSelectedButton] = useState(0);
  //Danh mục filter
  const [filteredDonuts, setFilteredDonuts] = useState(donutsData.filter((item) => item.category === 'Donut' ));
  //Danh sách sản phẩm theo filter
  const [selectedDonut, setSelectedDonut] = useState(null);
  

  // Bộ lọc các loại bánh donut và đôi màu
  const handleFilter = (category, index) => {
    setSelectedButton(index);
    const filteredData = donutsData.filter(
      (item) => item.category === category
    );
    setFilteredDonuts(filteredData);
  };

  // Khi chọn một sản phẩm (chua lam - chi tiet)
  const handleSelectDonut = (item) => {
    setSelectedDonut(item);
  };

  //Ham hien thi tung san pham
  const hienThi = ({ item }) => {
    return (
      <View style={styles.hienThi}>
        <Image source={item.image} style={{ width: 100, height: 100 }} />
        <View style={styles.info}>
          <Text style={{ fontWeight: 'bold', fontSize: 16 }}>{item.name}</Text>
          <Text>{item.description}</Text>
          <Text style={{ fontWeight: 'bold', fontSize: 16 }}>{item.price}</Text>
        </View>
        <View style={styles.viewButton}>
          <TouchableOpacity
            style={styles.buttonDetail}
            onPress={() => navigation.navigate('Detail', item)}>
            <Text>+</Text>
          </TouchableOpacity>
        </View>
      </View>
    );
  };

  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.text}>Welcome, Jala! </Text>
        <Text style={[styles.title, styles.text]}>Choice you best food</Text>
      </View>
      <View style={styles.inputView}>
        <TextInput
          style={styles.input}
          onChangeText={setFood}
          value={food}
          placeholder="Search food"
          placeholderTextColor="#ccc"
        />
      </View>
      <View style={styles.filterView}>
        <TouchableOpacity
          style={[
            styles.button,
            selectedButton === 0 ? styles.selectedButton : null,
          ]}
          onPress={() => handleFilter('Donut', 0)}>
          <Text>Donut</Text>
        </TouchableOpacity>
        <TouchableOpacity
          style={[
            styles.button,
            selectedButton === 1 ? styles.selectedButton : null,
          ]}
          onPress={() => handleFilter('Pink Donut', 1)}>
          <Text>Pink Donut</Text>
        </TouchableOpacity>
        <TouchableOpacity
          style={[
            styles.button,
            selectedButton === 2 ? styles.selectedButton : null,
          ]}
          onPress={() => handleFilter('Floating', 2)}>
          <Text>Floating</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.main}>
        <FlatList
          data={filteredDonuts}
          keyExtractor={(item) => item.id.toString()}
          renderItem={hienThi}
        />
      </View>
    </SafeAreaView>
  );
};

//Trang 2
const Detail = ({navigation, route}) => {
  // Tang giam
  const [soLuong, setSoLuong] = useState(1);
  return (
    <SafeAreaView style={{flex:1, padding :20}}>
      <View style= {styles.detailTop}>
        <Image source={route.params.image} style={{width:372, height:378}}/>
      </View>
      <View style= {styles.detailCenter}>
        <Text style ={{fontSize :25, fontWeight :'bold'}}>{route.params.name}</Text>
        <View style ={{flexDirection :'row', justifyContent :'space-between'}}> 
           <Text style={{ fontWeight: 'bold', fontSize: 16,color:'#777777' }}>{route.params.description}</Text>
           <Text style={{ fontWeight: 'bold', fontSize: 16 }}>{route.params.price}</Text>
        </View>
        <View  style ={{flexDirection :'row'}}>
           <Image source={require('./assets/Vector.png')} style={{marginRight:10}}/>
           <Text style={{ fontWeight: 'bold', fontSize: 16,color:'#777777' }}>Delivery in</Text>
        </View >
         <View style ={{flexDirection :'row', justifyContent :'space-between'}}>
           <Text style ={{fontSize :25, fontWeight :'bold', marginLeft :30}}>30 min</Text>
           <View style={{flexDirection:'row', alignItems:'center'}}>
               <TouchableOpacity style={{backgroundColor :'#f1b000', paddingHorizontal:10, borderRadius:5}}>
                           <Text style={{fontSize:25, color:'white',fontWeight:'bold'}}>-</Text>     
               </TouchableOpacity>
               <Text style={{marginLeft:7, marginRight:7, fontSize:25}}>{soLuong}</Text>
               <TouchableOpacity style={{backgroundColor :'#f1b000', paddingHorizontal:10, borderRadius:5}}>
                           <Text style={{fontSize:25, color:'white',fontWeight:'bold'}}>+</Text>     
               </TouchableOpacity>
           </View>
        </View>
        <View >
           <Text style ={{fontSize :25, fontWeight :'bold'}}>Restaurants info</Text>
           <Text style ={{fontSize :15}}>Order a Large Pizza but the size is the equivalent of a medium/small from other places at the same price range.</Text>
        </View>
      </View>
      <View style= {styles.detailBottom}>
         <TouchableOpacity style= {styles.buttonView}>
            <Text style={styles.buttonText}>Add to cart</Text>
         </TouchableOpacity>
      </View>
    </SafeAreaView>
  );
};

//Chuyen trang
const Stack = createNativeStackNavigator();

const MyStack = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Detail" component={Detail} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};


export default MyStack;
