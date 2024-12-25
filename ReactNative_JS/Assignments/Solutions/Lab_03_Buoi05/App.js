import * as React from 'react';
import { useState } from 'react';
import {
  View,
  Text,
  Image,
  StyleSheet,
  TouchableOpacity,
  Dimensions,
} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import styles from './components/HomeScreen/HomeScreen';
import styleDS from './components/Details/Details';

function HomeScreen({ navigation,route }) {
  const [selectedImage, setSelectedImage] = useState(
    require('./assets/vs_black.png')
  );

   React.useEffect(() => {
    if (route.params?.image) {
      setSelectedImage(route.params.image); 
    }
  }, [route.params?.image]);


  return (
    <View style={{ flex: 1,backgroundColor:'white' }}>
      <View style={{ flex: 2, alignItems: 'center', justifyContent: 'center' }}>
        <Image source={selectedImage} style={{ height: 300, width: 250 }} />
      </View>
      <View style={{ flex: 1, backgroundColor: 'white', marginHorizontal: 20 }}>
        <Text style={styles.text}>
          Điện thoại Vsmart Joy 3 -Hàng chính hãng
        </Text>
        <View
          style={{
            flexDirection: 'row',
            justifyContent: 'space-between',
            marginTop: 10,
          }}>
          <View style={{ flexDirection: 'row' }}>
            <Image
              source={require('./assets/star.png')}
              style={{ height: 20, width: 20 }}
            />
            <Image
              source={require('./assets/star.png')}
              style={{ height: 20, width: 20 }}
            />
            <Image
              source={require('./assets/star.png')}
              style={{ height: 20, width: 20 }}
            />
            <Image
              source={require('./assets/star.png')}
              style={{ height: 20, width: 20 }}
            />
            <Image
              source={require('./assets/star.png')}
              style={{ height: 20, width: 20 }}
            />
          </View>
          <Text style={styles.text}>(Xem 828 đánh giá)</Text>
        </View>
        <View
          style={{
            flexDirection: 'row',
            justifyContent: 'space-between',
            marginTop: 10,
          }}>
          <Text style={{ fontSize: 20, color: 'black', fontWeight: 'bold' }}>
            1.790.000 d
          </Text>
          <Text
            style={{
              textDecorationLine: 'line-through',
              fontSize: 20,
              color: 'black',
            }}>
            1.790.000 d
          </Text>
        </View>
        <Text
          style={{
            fontSize: 18,
            color: 'red',
            fontWeight: 'bold',
            marginTop: 10,
          }}>
          Ở ĐÂU RẺ HƠN HOÀN TIỀN
        </Text>
      </View>
      <View
        style={{
          flex: 1,
          alignItems: 'center',
          justifyContent: 'space-around',
        }}>
        <TouchableOpacity
          style={styles.button4}
          onPress={() =>
            navigation.navigate('Details', { image: selectedImage })
          }>
          <Text style={styles.buttonText4}>4 MÀU -CHỌN MÀU ></Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button}>
          <Text style={styles.buttonText}>CHỌN MUA</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

function DetailsScreen({navigation, route }) {
  const { image } = route.params; //Nhận dữ liệu
  const [selectedColor, setSelectedColor] = useState(null);

  const products = {
    '#C5F1FB': {
      imageUrl: require('./assets/vs_silver.png'),
      name: 'Điện Thoại Vsmart Joy 3\nHàng chính hãng',
      color: 'Bạc',
      provider: 'Tiki Tradding',
      price: '1.790.000 đ',
    },
    '#F30D0D': {
      imageUrl: require('./assets/vs_red.png'),
      name: 'Điện Thoại Vsmart Joy 3\nHàng chính hãng',
      color: 'Đỏ',
      provider: 'Tiki Tradding',
      price: '1.790.000 đ',
    },
    '#000000': {
      imageUrl: require('./assets/vs_black.png'),
      name: 'Điện Thoại Vsmart Joy 3\nHàng chính hãng',
      color: 'Đen',
      provider: 'Tiki Tradding',
      price: '1.790.000 đ',
    },
    '#234896': {
      imageUrl: require('./assets/vs_blue.png'),
      name: 'Điện Thoại Vsmart Joy 3\nHàng chính hãng',
      color: 'Xanh',
      provider: 'Tiki Tradding',
      price: '1.790.000 đ',
    },
  };

  const colors = Object.keys(products); //Tạo mảng màu [#C5F1FB, ]

  const selectColor = (color) => {
    setSelectedColor(color); // Cập nhật màu được chọn
  };

  const selectedProduct = products[selectedColor] || {
    // imageUrl: require('./assets/vs_blue.png'), // Ảnh mặc định khi chưa chọn màu
    imageUrl: image,
    name: 'Điện Thoại Vsmart Joy 3\nHàng chính hãng',
    color: null, 
    provider: null, 
    price: null,
  };

  return (
    <View style={styleDS.container}>
      <View style={styleDS.top}>
        <Image source={selectedProduct.imageUrl} style={styleDS.anh} />
        <View style={styleDS.textDT}>
          <Text style={styleDS.topText}>{selectedProduct.name}</Text>
          {selectedProduct.color && (
          <Text style={styleDS.topText}>Màu:{' '} <Text style={styleDS.bold}> {selectedProduct.color} </Text>   </Text>
          )}
          {selectedProduct.provider && (
          <Text style={styleDS.topText}>Cung cấp bởi:{' '}  <Text style={styleDS.bold}>{selectedProduct.provider}</Text> </Text> 
          )}
          {selectedProduct.price && (
               <Text style={[styleDS.bold,styleDS.topText]}>{selectedProduct.price}</Text>
          )}
        </View>
      </View>

      <View style={styleDS.center}>
        <Text style={styleDS.topText}>Chọn một màu bên dưới</Text>

        <View style={{ flexDirection: 'column', alignItems: 'center' }}>
          {colors.map((color, index) => (
            <TouchableOpacity
              key={index}
              style={{
                width: 100,
                height: 100,
                marginBottom: 10,
                borderRadius: 5,
                backgroundColor: color,
              }}
              onPress={() => selectColor(color)}
            />
          ))}
        </View>

        <TouchableOpacity style={styleDS.buttonDetail}                   
                           onPress={() => navigation.navigate('Home',{ image: selectedProduct.imageUrl })}
        >
            <Text style={{ fontWeight: 'bold', color: 'white', fontSize: 25 }}>
                 XONG
            </Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}


const Stack = createNativeStackNavigator();
function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={HomeScreen} />
        <Stack.Screen name="Details" component={DetailsScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;
