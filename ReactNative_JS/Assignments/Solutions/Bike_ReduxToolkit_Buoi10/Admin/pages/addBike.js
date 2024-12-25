import React, { useState } from 'react';
import {
  View,
  Text,
  TextInput,
  StyleSheet,
  Alert,
  Image,
  TouchableOpacity,
  ScrollView,
} from 'react-native';
import { useDispatch } from 'react-redux';
import { addBike } from '../redux_toolkit/slice'; // Đảm bảo bạn đã tạo action để thêm xe đạp
import * as ImagePicker from 'expo-image-picker';
import { Picker } from '@react-native-picker/picker';

const AddBikeScreen = ({ navigation }) => {
  const [name, setName] = useState('');
  const [price, setPrice] = useState('');
  const [image, setImage] = useState('');

  const [category, setCategory] = useState('Roadbike');

  const dispatch = useDispatch();

  const handleAddBike = () => {
    // Kiểm tra các trường không được bỏ trống
    if (!name || !price || !image) {
      Alert.alert('Lỗi', 'Vui lòng nhập đầy đủ thông tin');
      return;
    }

    // Tạo đối tượng bike để gửi đi
    const newBike = {
      name,
      price,
      image,
      category,
    };

    // Gửi action addBike đến Redux để thêm xe đạp
    dispatch(addBike(newBike));

    // Sau khi thêm xe đạp thành công, điều hướng về trang quản lý xe đạp hoặc trang chính
    Alert.alert('Thành công', 'Xe đạp đã được thêm');
    navigation.goBack();
  };

  // Hàm để chọn ảnh từ thiết bị
  const pickImage = async () => {
    // Kiểm tra quyền truy cập ảnh
    const permissionResult =
      await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (permissionResult.granted === false) {
      Alert.alert('Cần quyền truy cập vào thư viện ảnh');
      return;
    }

    // Mở thư viện ảnh để chọn hình ảnh
    const pickerResult = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsEditing: true,
      aspect: [4, 3],
      quality: 1,
    });

    if (!pickerResult.cancelled) {
      setImage(pickerResult.assets[0].uri);
    }
  };

  return (
    <ScrollView contentContainerStyle={styles.container}>
      <View style={styles.top}>
        <Text style={styles.header}>Thêm Xe Đạp</Text>
        {/* Nhập tên xe */}
       <Text style={styles.label}>Tên Xe</Text>
        <TextInput
          style={styles.input}
          placeholder="Tên xe"
          value={name}
          onChangeText={setName}
        />

        {/* Nhập giá */}
        <Text style={styles.label}>Giá Xe</Text>
        <TextInput
          style={styles.input}
          placeholder="Giá"
          keyboardType="numeric"
          value={price}
          onChangeText={setPrice}
        />

        {/* Nhập hình ảnh */}
        
        <TouchableOpacity style={styles.imagePicker} onPress={pickImage}>
          <Text style={styles.buttonText}>Chọn Hình Ảnh</Text>
        </TouchableOpacity>

        {image ? <Image source={{ uri: image }} style={styles.imagePreview} /> : <Text style={{fontSize:15, color :'red', fontWeight:'bold', marginBottom:10}}>Bạn vui lòng chọn ảnh </Text>}
       
        

        {/* Chọn loại xe */}
        <Text style={styles.label}>Loại Xe</Text>
        <Picker
          selectedValue={category}
          onValueChange={(itemValue) => setCategory(itemValue)}
          style={styles.picker}>
          <Picker.Item label="Roadbike" value="Roadbike" />
          <Picker.Item label="Mountain" value="Mountain" />
        </Picker>

      </View>

      {/* Nút thêm xe */}
      <View style={styles.addButton}>
        <TouchableOpacity style={styles.button} onPress={handleAddBike}>
          <Text style={{color:'white', fontSize:20, fontWeight:'bold'}}>Thêm Xe Đạp</Text>
        </TouchableOpacity>
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    justifyContent: 'center',
    backgroundColor:'white',
  },
  top: {
    flex: 3,
  },
  header: {
    fontSize: 24,
    fontWeight: 'bold',
    textAlign: 'center',
    marginBottom: 20,
  },
  input: {
    height: 40,
    borderColor: '#ccc',
    borderWidth: 1,
    marginBottom: 20,
    paddingLeft: 8,
    borderRadius: 5,
  },

  picker: {
    width: '100%',
    height: 50,
    marginBottom: 15,
    backgroundColor:'lightgray',
  },

  imagePicker: {
    padding: 10,
    borderRadius: 8,
    width: '50%',
    alignItems: 'center',
    marginBottom: 10,
    borderWidth :1,
    backgroundColor:'lightgray'
  },
  label: {
    fontSize: 16,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  button: {
    padding: 15,
    backgroundColor: 'green',
    borderRadius: 8,
    width: '80%',
    alignItems: 'center',
  },
  buttonText: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  imagePreview: {
    width: 200,
    height: 200,
    borderRadius: 10,
    marginTop: 15,
    marginBottom: 15,
    resizeMode: 'contain',
  },

  addButton: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default AddBikeScreen;
