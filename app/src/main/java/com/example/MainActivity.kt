package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = BackgroundDark,
                    bottomBar = { BottomNavBar() }
                ) { innerPadding ->
                    DashboardScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        HeaderSection(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
        
        GreetingCard(modifier = Modifier.padding(bottom = 16.dp))
        
        FeaturesGrid(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 16.dp)
        )
        
        ContextMemoryCard(modifier = Modifier.padding(bottom = 16.dp))
    }
}

@Composable
fun HeaderSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(PrimaryAccent, PrimaryAccentDark)
                        )
                    )
                    .border(2.dp, PrimaryAccent.copy(alpha = 0.3f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("P", color = Color(0xFF1A1C1E), fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "พลอยใส",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(StatusGreen))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "อัจฉริยะพร้อมช่วย",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = StatusGreen.copy(alpha = 0.8f),
                        letterSpacing = 1.sp
                    )
                }
            }
        }
        
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(SurfaceDark)
                .border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(2.dp)
                    .background(PrimaryAccent)
                    .shadow(elevation = 4.dp, spotColor = PrimaryAccent, ambientColor = PrimaryAccent)
            )
        }
    }
}

@Composable
fun GreetingCard(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(16.dp, RoundedCornerShape(28.dp), spotColor = Color.Black.copy(alpha = 0.5f))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(28.dp)),
        color = SurfaceDark,
        shape = RoundedCornerShape(28.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "GREETING",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = PrimaryAccent,
                letterSpacing = 1.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = buildAnnotatedString {
                    append("สวัสดีค่ะ ")
                    withStyle(style = SpanStyle(color = PrimaryAccent, fontWeight = FontWeight.Bold)) {
                        append("คุณป๋อ")
                    }
                    append("! พลอยใสเตรียมข้อมูลเรียบร้อยแล้วนะคะ วันนี้อยากให้ช่วยดูแลส่วนไหนก่อนดีคะ?")
                },
                fontSize = 20.sp,
                lineHeight = 28.sp,
                color = TextPrimary
            )
        }
    }
}

@Composable
fun FeaturesGrid(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            FeatureCard(
                icon = "🎵",
                iconBg = IconBgMusic,
                title = "Music & Artist",
                subtitle = "ไอเดียเพลง & คอร์ด",
                modifier = Modifier.weight(1f).fillMaxSize()
            )
            FeatureCard(
                icon = "💻",
                iconBg = IconBgDev,
                title = "Dev & IT",
                subtitle = "โค้ด & จัดการ VPS",
                modifier = Modifier.weight(1f).fillMaxSize()
            )
        }
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            FeatureCard(
                icon = "🔧",
                iconBg = IconBgRepair,
                title = "Repair Shop",
                subtitle = "วิธีแก้งานซ่อม",
                modifier = Modifier.weight(1f).fillMaxSize()
            )
            FeatureCard(
                icon = "📋",
                iconBg = IconBgManagement,
                title = "Management",
                subtitle = "สรุปงาน & ตาราง",
                modifier = Modifier.weight(1f).fillMaxSize()
            )
        }
    }
}

@Composable
fun FeatureCard(icon: String, iconBg: Color, title: String, subtitle: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
            .clickable { },
        color = SurfaceVariantDark,
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(iconBg),
                contentAlignment = Alignment.Center
            ) {
                Text(text = icon, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = subtitle, fontSize = 12.sp, color = TextSecondary)
            }
        }
    }
}

@Composable
fun ContextMemoryCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(PrimaryAccentDark.copy(alpha = 0.4f), SurfaceDark)
                )
            )
            .drawBehind { 
                drawLine(
                    color = PrimaryAccent,
                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(0f, size.height),
                    strokeWidth = 12.dp.toPx()
                )
            }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "CONTEXT MEMORY",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryAccent,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "จำได้ว่าคุณป๋อมีคิวส่งมิกซ์เพลงใหม่พรุ่งนี้ค่ะ",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.05f)),
                contentAlignment = Alignment.Center
            ) {
                Text("→", fontSize = 12.sp, color = Color.White.copy(alpha = 0.4f))
            }
        }
    }
}

@Composable
fun BottomNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(SurfaceDark)
            .border(1.dp, Color.White.copy(alpha = 0.05f))
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFF4A4458))
                .padding(horizontal = 20.dp, vertical = 6.dp)
        ) {
            Text("🏠", fontSize = 20.sp)
        }
        Text("💬", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
        Text("📅", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
        Text("⚙️", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
    }
}
