package com.tcoding.albatechnius.ui.fragments.home.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.textViewDroneInfo1.setText(droneInfo1())
        binding.textViewDroneInfo2.setText(droneInfo2())
        binding.textViewDroneInfo3.setText(droneInfo3())
        return view
    }

    fun droneInfo1() : String {
        val droneInfo =
            " Sürü halde çalışacak Tarımsal İlaçlama ve sürü halinde keşif, gözetleme yapması planlanan İha’lara ait algoritmaları işlemek için otopilotlar ile uçuş bilgisayarları kullanılması planlanmaktadır. Bunun yanında kablosuz haberleşme ve gps bağlantıları da kullanılacaktır. Aşağıda hem yazılıma ait ortam bilgisi, hem de altyapı belirtilmektedir\n\n";
        val droneInfo2 =
            "1-)Pixhawk 2.4.8 Versiyonu(Otopilot)\n-Gelişmiş 32-bit ARM CortexM4 yüksek performanslı işlemciler, NuttX RTOS gerçek zamanlı işletim sistemini çalıştırabilir\n-14 PWM / servo çıkışı\n-Veriyolu arayüzü (UART, I2C, SPI, CAN)\n-Otomatik ve manuel mod\n-32bit STM32F427 Cortex M4, FPU ile birlikte\n-32-bit STM32F103 arızaya dayanıklı ortak işlemci\n-L3GD20H 16 bit jiroskop\n-X4HBA 303H 14 bit ivmeölçer / manyetometre\n-MPU 6000 3 eksenli ivmeölçer / jiroskop\n-MS5607 barometresi\n\n";

        return droneInfo + droneInfo2
    }

    fun droneInfo2() : String {
        val droneInfo3 =
            "2-)Pixhawk Cube Versiyonu\n-Yeni nesil H7 İşlemci\n-UAvionix'ten 1.090 MHz ADS-B alıcısına sahiptir\n-Sensörler: İvmeölçer, Jiroskop, Pusula,\tBarometrik Basınç Sensörü\n\n";
        val droneInfo4 =
            "3-)HERE3 GPS/GNSS\n-Alıcı Tipi: u-blox M8 yüksek hassasiyetli GNSS modülleri (M8P)\n-Uydu Takımyıldızı: GPS L1C / A, GLONASS L1OF, BeiDou B1I\n-Konumlandırma doğruluğu: 3D FIX: 2,5 m / RTK: 0,025 m\n-İşlemci: STM32F30\n-IMU sensörü: ICM20948\n-Navigasyon Güncelleme Hızı: Maks: 8Hz\n\n";
        return droneInfo3 + droneInfo4
    }

    fun droneInfo3(): String {
        val droneInfo5 =
            "4-)Raspberry Pi4 8GB\n-RAM:8GB LPDDR4 SKU\n-Ethernet:Gerçek Gigabit\n-USB	2 × USB 3.0 ve 2 × USB 2.0 bağlantı portu\n-Kablosuz Bağlantı	4/5.0 GHz 802.11ac destekleyen kablosuz ağ ve Bluetooth 5.0 BLE\n-GPIO:40 adet GPIO bağlantısı\n-HDMI	2 × mikro HDMI bağlantı noktası (1 × 4K@60Hz veya 2 × 4K@30Hz)\n-Decode / Encode	265 (4kp60 Decode) ve H264 (1080p60 Decode, 1080p30 Encode)\n\n";
        val droneInfo6 =
            "5-) LiDAR\n-Aralık: 0.13m - 8m\n-Süpürme frekansı: 6.2Hz\n-Lazer gücü: 3mW(max)\n-Lazer sınıfı: Class1 3mw/780nm\n-Çalışma ortamı sıcaklığı: 0 ° C - 45 ° C\n-Lazer dalga boyu: 780nm\n-Doğruluk: <2% 5m\n-Çalışma modu: 8 bit";
        val droneInfo7 =
            "\n\n6-)Telemetri RDF900 915Mhz\n-Frekans aralığı: 902-928 MHzMaks\n-Dış iletişim mesafesi> 40 KM (not: iletişim mesafesi antene bağlıdır)\n-Çift anten arayüz tasarımı, otomatik geçiş yapabilir\n-20DB düşük gürültü amplifikatörü ile LPF kullanın\n-Hava iletim hızı 250 kbps'ye kadar\n-Çalışma sıcaklığı:-40 ~ + 85 derece C\n-Boyut: 30*57*12.8mm\nAğırlık: 14.5g";
        return droneInfo5 + droneInfo6 + droneInfo7
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }


}