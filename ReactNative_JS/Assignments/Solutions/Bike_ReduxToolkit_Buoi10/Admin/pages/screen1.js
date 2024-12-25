import { View, Text, Image, TouchableOpacity, StyleSheet,SafeAreaView } from 'react-native';

const Screen1 = ({navigation}) => {
  return (
    <SafeAreaView style={screen1.container}>
      <View style={screen1.top}>
        <Text style={{ fontSize: 20, textAlign: 'center', fontWeight: 'bold' }}>
          A premium online store for {'\n'} sporter and their stylish choice
        </Text>
      </View>

      <View style={screen1.center}>
        <View style={screen1.viewImage}>
          <Image source={require('../assets/bifour_-removebg-preview.png')} style= {screen1.img}/>
        </View>
      </View>

      <View style={screen1.footer}>
        <Text style={{ fontSize: 25, fontWeight: 'bold', textAlign: 'center' }}>
          POWER BIKE {'\n'} SHOP
        </Text>
        <TouchableOpacity
          style={screen1.buttonView}
          onPress={() => navigation.navigate('Admin')}>
          <Text style={{ color: 'white', fontWeight: 'bold', fontSize: 20, textAlign:'center' }}>
            Get Started
          </Text>
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  );
};

const screen1 = StyleSheet.create({
   container :{
     flex:1,
   },
   top :{
     flex:0.5,
     padding:10,
    alignItems :'center',
     justifyContent :'center'
   },
   center :{
     flex:2,
     padding:10,
   },
   viewImage :{
      padding :20,
      backgroundColor:'#f8e6e5',
      borderRadius :45,

   },
   img :{
     width :'100%',
     height :'100%',
     resizeMode :'contain',
   },
   footer :{
     flex:1,
     padding:10,
     justifyContent :'space-between',
   },
   buttonView :{
     backgroundColor :'#e94141',
     padding:20,
     borderRadius :40,
     marginBottom:20,
   }
})


export default Screen1;